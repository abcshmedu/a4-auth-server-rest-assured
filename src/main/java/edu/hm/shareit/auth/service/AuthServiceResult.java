/*
 * Wolfgang Gabler
 *
 * Software: Mac OS X 10.12, Oracle Java 1.8.0_111 SE
 * System: Intel Core i7-4850HQ, 16 GByte RAM
 */
package edu.hm.shareit.auth.service;

/**
 * @author Wolfgang Gabler, wgabler@hm.edu
 * @since 18.05.17
 */
public class AuthServiceResult {

    private int code;
    private String msg;
    private String content;

    public AuthServiceResult(int code, String msg, String content) {
        this.code = code;
        this.msg = msg;
        this.content = content;
    }
}
