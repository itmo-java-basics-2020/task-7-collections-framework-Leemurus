package ru.ifmo.collections;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class KthLargestTest {
    @Test
    public void kthLargestTest() {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        assertThat(kthLargest.add(3), is(4));
        assertThat(kthLargest.add(5), is(5));
        assertThat(kthLargest.add(10), is(5));
        assertThat(kthLargest.add(9), is(8));
        assertThat(kthLargest.add(4), is(8));
    }

    @Test
    public void kthLargestTest_smallArray() {
        KthLargest kthLargest = new KthLargest(1, new int[]{1});
        assertThat(kthLargest.add(10), is(10));
        assertThat(kthLargest.add(-1), is(10));
        assertThat(kthLargest.add(11), is(11));
    }

    @Test
    public void kthLargestTest_2() {
        KthLargest kthLargest = new KthLargest(3, new int[]{10, 9, 8, 7, 6});
        assertThat(kthLargest.add(9), is(9));
        assertThat(kthLargest.add(10), is(9));
        assertThat(kthLargest.add(10), is(10));
        assertThat(kthLargest.add(11), is(10));
        assertThat(kthLargest.add(2), is(10));
    }
}
