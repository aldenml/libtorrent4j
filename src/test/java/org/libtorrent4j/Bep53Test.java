/*
 * Copyright (c) 2018 Alden Torres
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
 */

package org.libtorrent4j;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author aldenml
 */
public class Bep53Test {

    @Test
    public void testSimple() {

        String uri = "magnet:?xt=urn:btih:882a5d2a7a9df0d9e09f626fd5d5cbf666498410&so=0,2,4-6";

        AddTorrentParams params = AddTorrentParams.parseMagnetUri(uri);

        Priority[] priorities = params.filePriorities();

        assertEquals(Priority.DEFAULT, priorities[0]);
        assertEquals(Priority.IGNORE, priorities[1]);
        assertEquals(Priority.DEFAULT, priorities[2]);
        assertEquals(Priority.IGNORE, priorities[3]);
        assertEquals(Priority.DEFAULT, priorities[4]);
        assertEquals(Priority.DEFAULT, priorities[5]);
        assertEquals(Priority.DEFAULT, priorities[6]);
    }
}
