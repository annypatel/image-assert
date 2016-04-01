/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Hotwire, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package com.hotwire.imageassert.imagemagick

import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream

object AsyncReader {
    @JvmStatic fun read(inputStream: InputStream): ByteArray {
        val byteArrayOutputStream = ByteArrayOutputStream()
        val thread = Thread(Runnable {
            try {
                val buffer = ByteArray(8192)
                var length: Int = 0
                while ({ length = inputStream.read(buffer); length }() != -1) {
                    byteArrayOutputStream.write(buffer, 0, length)
                    Thread.`yield`()
                }
            } catch (e: IOException) {
                throw RuntimeException(e)
            }
        })
        try {
            thread.start()
            thread.join()
        } catch (e: InterruptedException) {
            throw RuntimeException(e)
        }
        return byteArrayOutputStream.toByteArray()
    }
}
