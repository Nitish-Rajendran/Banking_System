package nitish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;


@WebServlet("/login")
public class login extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
       
        StringBuilder body = new StringBuilder();
        try (BufferedReader reader = request.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                body.append(line).append("\n");
            }
        }
        
        String sampleUserName="nitish";
        String samplePassword="nyx@123";
        
        JSONObject inputData = new JSONObject(body.toString());
        
        String name = inputData.getString("name");
        String password = inputData.getString("password");
        
        JSONObject responseObj = new JSONObject();
        
        if(sampleUserName.equals(name) && samplePassword.equals(password)) {
            responseObj.put("status", true);
        } else {
            responseObj.put("status", false);
        }
        
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(responseObj);
        out.flush();
        out.close();
    }
}