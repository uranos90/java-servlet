import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;

@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String num1Str = request.getParameter("num1");
        String num2Str = request.getParameter("num2");
        String operator = request.getParameter("operator");
        
        try {
            double num1 = Integer.parseInt(num1Str);
            double num2 = Integer.parseInt(num2Str);
            
            if (operator == null || operator.isEmpty()) {
                request.setAttribute("error", "演算子を選択してください");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                return;
            }

            if (num2 == 0 && operator.equals("/")){
                request.setAttribute("error", "0で割ることはできません");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                return;
            } 
            double result = 0;
            switch (operator){
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
            }
            DecimalFormat df = new DecimalFormat("#.####");
            String formattedResult = df.format(result);
            request.setAttribute("result", formattedResult);
        } catch(NumberFormatException e) {
            request.setAttribute("error", "数値を入力してください");
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }
}