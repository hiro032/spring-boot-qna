package com.codessquad.qna.utill;

import com.codessquad.qna.domain.User;
import com.codessquad.qna.exception.NotLoginException;

import javax.servlet.http.HttpSession;

public class HttpSessionUtils {
    private final static String USER_SESSION_KEY = "sessionedUser";

    public static void loginCheck(HttpSession session) {
        if(session.getAttribute(USER_SESSION_KEY).equals(null)) {
            throw new NotLoginException();
        }
    }

    public static User getLoginUser(HttpSession session) {
        loginCheck(session);
        User user = (User)session.getAttribute(USER_SESSION_KEY);
        return user;
    }

    public static User setSession(User user, HttpSession session) {
        session.setAttribute(USER_SESSION_KEY, user);
        return user;
    }

    public static void removeSession(HttpSession session) {
        getLoginUser(session);
        session.removeAttribute(USER_SESSION_KEY);
    }

}
