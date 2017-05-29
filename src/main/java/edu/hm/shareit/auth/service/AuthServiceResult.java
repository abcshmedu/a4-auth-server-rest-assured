/*
 * Wolfgang Gabler
 *
 * Software: Mac OS X 10.12, Oracle Java 1.8.0_111 SE
 * System: Intel Core i7-4850HQ, 16 GByte RAM
 */
package edu.hm.shareit.auth.service;

import java.util.Objects;

import edu.hm.shareit.auth.model.User;

/**
 * @author Wolfgang Gabler, wgabler@hm.edu
 * @author Andrea Limmer, limmer@hm.edu
 * @since 18.05.17
 */
public class AuthServiceResult {

    public static final AuthServiceResult OK = new AuthServiceResult(200, "OK", null);
    public static final AuthServiceResult UNAUTHORIZED = new AuthServiceResult(401, "Unauthorized", null);

    private final int code;
    private final String msg;
    private final String content;

    public AuthServiceResult(int code, String msg, String content) {
        this.code = code;
        this.msg = msg;
        this.content = content;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public String getContent() {
        return content;
    }

	@Override
	public int hashCode() {
		return Objects.hash(code, msg, content);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AuthServiceResult result = (AuthServiceResult) obj;
        return Objects.equals(code, result.code) &&
                Objects.equals(msg, result.msg) &&
                Objects.equals(content, result.content);
	}

	@Override
	public String toString() {
		return "AuthServiceResult {code=" + code + ", msg=" + msg + ", content=" + content + "}";
	}
	
}
