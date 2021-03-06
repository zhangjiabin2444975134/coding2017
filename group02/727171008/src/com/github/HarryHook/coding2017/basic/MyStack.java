/*
 * created by Harry 2017-2-22 10:48:34
 * 实现简单的Stack
 */
package com.github.HarryHook.coding2017.basic;

import java.util.*;

public class MyStack {
    private MyArrayList elementData = new MyArrayList();
    private int size = 0;

    // 入栈操作
    public void push(Object o) {
	elementData.add(o);
	size++;
    }

    // 出栈操作
    public Object pop() {
	Object obj = peek();
	elementData.remove(size() - 1);
	size--;
	return obj;
    }

    // 获取当前栈顶元素，不用出栈
    public Object peek() {
	if (isEmpty()) {
	    throw new EmptyStackException();
	}
	return elementData.get(size() - 1);
    }

    // 判断栈是否为空
    public boolean isEmpty() {
	return size() == 0;
    }

    // 返回栈内元素个数
    public int size() {
	return size;
    }
}
