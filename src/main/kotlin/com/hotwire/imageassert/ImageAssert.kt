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

package com.hotwire.imageassert

import com.hotwire.imageassert.imagemagick.ImageMagick
import com.hotwire.imageassert.listener.Result
import com.hotwire.imageassert.listener.ResultListener
import java.util.*
import java.util.Arrays.asList

/**
 * Main entry point for image comparison.
 */
class ImageAssert private constructor(private var actual: Image) {

    private val resultListeners = LinkedList<ResultListener>()
    private val ignore = ArrayList<Rectangle>()
    private var id = ""
    private var threshold: Int = 0

    fun `as`(id: String): ImageAssert {
        this.id = id
        return this
    }

    /**
     * Ignore difference up to X pixels.
     *
     * @param threshold Number of pixels to be ignored.
     * @return Reference to this object.
     */
    fun ignoring(threshold: Int): ImageAssert {
        this.threshold = threshold
        return this
    }

    /**
     * Ignore difference in given areas.
     *
     * @param rectangles Areas to be ignored.
     * @return Reference to this object.
     */
    fun ignoring(vararg rectangles: Rectangle): ImageAssert {
        ignore.addAll(asList(*rectangles))
        return this
    }

    fun reportingTo(resultListener: ResultListener): ImageAssert {
        resultListeners.add(resultListener)
        return this
    }

    /**
     * Compare images and report comparison result.
     *
     * @param other Base Image instance.
     */
    fun isEqualTo(other: Image) {
        var expected = other
        var mask = ImageMagick.fill(expected)

        for (rectangle in ignore) {
            mask = ImageMagick.rectangle(mask, rectangle)
        }

        actual = ImageMagick.copyOpacity(actual, mask)
        expected = ImageMagick.copyOpacity(expected, mask)

        val r = ImageMagick.compare(expected, actual)
        actual = ImageMagick.removeAlpha(actual)
        expected = ImageMagick.removeAlpha(expected)
        val result = Result(id, actual, expected, r.image, r.delta, threshold)

        for (resultListener in resultListeners) {
            resultListener.report(result)
        }
    }

    companion object {
        /**
         * Use this method to create ImageAssert instance.
         *
         * @param actual Image instance.
         * @return new instance of ImageAssert.
         */
        @JvmStatic fun assertThat(actual: Image): ImageAssert {
            return ImageAssert(actual)
        }
    }
}
