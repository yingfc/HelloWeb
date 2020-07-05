import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Demo")
public class Demo extends HttpServlet {
    @Override
    public void init (ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    public void service (ServletRequest req, ServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        res.setContentType("text/html; charset=utf-8");
        PrintWriter out = res.getWriter();
        out.println("<html><body bgcolor=yellow>");
        String str = req.getParameter("english");
        if (str == null || str.length() == 0){
            return;
        }
        String [] word = str.split("[^a-zA-Z]+");
        int n = 0;
        try{
            for(int i = 0; i < word.length; i++) {
                if (word[i].length() >= 1){
                    n++;
                    out.print("<br>" + word[i]);
                }
            }
        }catch (NumberFormatException e){
            out.print(" " + e);
        }
        out.print("<h2>句子中单词数目为：" + n);
        out.print("</body></html>");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置网页响应类型
        response.setContentType("text/html");
        //实现具体操作
        PrintWriter out = response.getWriter();
        out.println("This is a new servlet page");
    }
}