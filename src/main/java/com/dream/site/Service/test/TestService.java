package com.dream.site.Service.test;

import org.springframework.stereotype.Service;

import java.util.Queue;

@Service
public class TestService {


    public static void showAll(Queue q) {
        q.add(new Integer(42));
        while (!q.isEmpty())
            System.out.print(" --- " + q.remove() + " ");
    }

}
