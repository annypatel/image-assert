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

/**
 * Sample images in PNG format represented as ByteArrays.
 */
enum class Samples(val bytes: ByteArray) {
    WHITE(byteArrayOf(-119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 2, 0, 0, 0, 2, 8, 4, 0, 0, 0, -40, -65, -59, -81, 0, 0, 0, 2, 98, 75, 71, 68, 0,  0, -86,  -115,  35,  50, 0, 0, 0, 9, 112, 72, 89, 115, 0, 0, 11, 19, 0, 0, 11, 19, 1, 0, -102, -100, 24, 0, 0, 0, 7, 116, 73, 77, 69, 7, -33, 7, 6, 21, 7, 27, 103,  62, -71, 38, 0, 0, 0, 18, 73, 68, 65, 84, 8, -41, 99,  -4, -1, -97, -127, -127, -119, -127, -127, -127, 1, 0, 17, 13, 2, 2, 123,  25, -47, -125, 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126)),
    BLACK(byteArrayOf(-119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 2, 0, 0, 0, 2, 8, 4, 0, 0, 0, -40, -65, -59, -81, 0, 0, 0, 2, 98, 75, 71, 68, 0, -1, -121, -113, -52, -65, 0, 0, 0, 9, 112, 72, 89, 115, 0, 0, 11, 19, 0, 0, 11, 19, 1, 0, -102, -100, 24, 0, 0, 0, 7, 116, 73, 77, 69, 7, -33, 7, 6, 21, 9, 55, -53, 101,  -8, 75, 0, 0, 0, 18, 73, 68, 65, 84, 8, -41, 99, 100, -8, -49,  -64,  -64,  -60, -64,   -64,  -64, 0, 0,  8, 22, 1, 3,  97, -64,  17,  111, 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126));
}
