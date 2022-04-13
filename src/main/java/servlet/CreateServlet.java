package servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Car;
import model.Item;
import model.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import store.Hibernate;
import javax.servlet.ServletContext;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


public class CreateServlet extends HttpServlet {

    private static final Gson GSON = new GsonBuilder().create();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        HttpSession sc = req.getSession();
        User user = (User) sc.getAttribute("user");
        String brand = req.getParameter("brand");
        String description = req.getParameter("description");
        String price = req.getParameter("price");
        String body = req.getParameter("body");
        String color = req.getParameter("color");
        String photo = req.getParameter("file");
        Car car = Hibernate.getInstance().addCar(new Car(brand, body, color));
        // double d = Double.parseDouble(price);
        Item item = Item.of(description, 10, user, car, photo);
        Hibernate.getInstance().add(item);
        save(item.getId(), req);
        resp.sendRedirect(req.getContextPath() + "/index");
        System.out.println(item);

    }

    private void save(int id, HttpServletRequest req) {
        System.out.println("doPost " + id);
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletContext servletContext = this.getServletConfig().getServletContext();
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            List<FileItem> items = upload.parseRequest(req);
            File folder = new File("c:\\images\\");
            if (!folder.exists()) {
                folder.mkdir();
            }
            for (FileItem item : items) {
                if (!item.isFormField()) {
                    File file = new File(folder + File.separator + id + ".jpg");
                    try (FileOutputStream out = new FileOutputStream(file)) {
                        out.write(item.getInputStream().readAllBytes());
                    }
                }
            }
        } catch (FileUploadException | IOException e) {
            e.printStackTrace();
        }
    }
}
