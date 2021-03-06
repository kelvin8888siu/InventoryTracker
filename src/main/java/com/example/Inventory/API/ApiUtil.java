package com.example.Inventory.API;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.context.request.NativeWebRequest;

public class ApiUtil {
    public ApiUtil() {
    }

    public static void setExampleResponse(NativeWebRequest req, String contentType, String example) {
        try {
            HttpServletResponse res = (HttpServletResponse)req.getNativeResponse(HttpServletResponse.class);
            res.setCharacterEncoding("UTF-8");
            res.addHeader("Content-Type", contentType);
            res.getWriter().print(example);
        } catch (IOException var4) {
            throw new RuntimeException(var4);
        }
    }
}