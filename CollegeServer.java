package college;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class CollegeServer {
    private static final int PORT = 8080;
    private static final Path WEB_ROOT = Path.of("public").toAbsolutePath().normalize();

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
        server.createContext("/api/college", CollegeServer::collegeInfo);
        server.createContext("/", CollegeServer::serveFile);
        server.setExecutor(null);
        server.start();
        System.out.println("Orchid College website running at http://localhost:" + PORT);
    }

    private static void collegeInfo(HttpExchange exchange) throws IOException {
        if (!"GET".equalsIgnoreCase(exchange.getRequestMethod())) {
            send(exchange, 405, "text/plain; charset=UTF-8", "Method not allowed");
            return;
        }
        College c = CollegeData.getCollege();
        StringBuilder json = new StringBuilder("{");
        json.append("\"name\":\"").append(escape(c.getName())).append("\",")
            .append("\"location\":\"").append(escape(c.getLocation())).append("\",")
            .append("\"address\":\"").append(escape(c.getAddress())).append("\",")
            .append("\"phone\":\"").append(escape(c.getPhone())).append("\",")
            .append("\"email\":\"").append(escape(c.getEmail())).append("\",")
            .append("\"website\":\"").append(escape(c.getWebsite())).append("\",")
            .append("\"status\":\"").append(escape(c.getStatus())).append("\",")
            .append("\"about\":\"").append(escape(c.getAbout())).append("\"}");
        send(exchange, 200, "application/json; charset=UTF-8", json.toString());
    }

    private static void serveFile(HttpExchange exchange) throws IOException {
        String requested = exchange.getRequestURI().getPath();
        if (requested.equals("/")) requested = "/index.html";
        Path file = WEB_ROOT.resolve(requested.substring(1)).normalize();
        if (!file.startsWith(WEB_ROOT) || !Files.isRegularFile(file)) {
            send(exchange, 404, "text/plain; charset=UTF-8", "404 - Page not found");
            return;
        }
        String type = Files.probeContentType(file);
        if (type == null) type = "application/octet-stream";
        byte[] bytes = Files.readAllBytes(file);
        exchange.getResponseHeaders().set("Content-Type", type + (type.startsWith("text/") ? "; charset=UTF-8" : ""));
        exchange.sendResponseHeaders(200, bytes.length);
        exchange.getResponseBody().write(bytes);
        exchange.close();
    }

    private static String escape(String value) {
        return value.replace("\\", "\\\\").replace("\"", "\\\"")
                    .replace("\n", "\\n").replace("\r", "");
    }

    private static void send(HttpExchange exchange, int status, String type, String body) throws IOException {
        byte[] bytes = body.getBytes(java.nio.charset.StandardCharsets.UTF_8);
        exchange.getResponseHeaders().set("Content-Type", type);
        exchange.sendResponseHeaders(status, bytes.length);
        exchange.getResponseBody().write(bytes);
        exchange.close();
    }
}
