import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App{
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) ->{
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/addStylist", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/add-stylist.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/listStylists", (request, response) ->{
      Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("stylistInput");
      Stylist newStylist = new Stylist(name);

      newStylist.save();

      Boolean addedNewStylist = true;

      model.put("stylists", Stylist.all());
      model.put("addedNewStylist", addedNewStylist);
      model.put("template", "templates/list-stylists.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/addClient/:id", (request, response) ->{
      Map<String, Object> model = new HashMap<String, Object>();

      Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));

      model.put("stylist", stylist);
      model.put("template", "templates/add-client.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/addClient", (request,response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String clientName = request.queryParams("clientName");
      int stylist_id = Integer.parseInt(request.queryParams("stylist_id"));

      Client newClient = new Client(clientName, stylist_id);
      newClient.save();

      Stylist stylist = Stylist.find(stylist_id);

      Boolean addedNewClient = true;

      model.put("addedNewClient", addedNewClient);
      model.put("stylist", stylist);
      model.put("template", "templates/add-client.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/client/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Client client = Client.find(Integer.parseInt(request.params(":id")));
      Stylist stylist = Stylist.find(client.getStylistId());
      model.put("client", client);
      model.put("stylist", stylist);
      model.put("template", "templates/client.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/addClient", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/add-client.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/listStylists", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("stylists", Stylist.all());
      model.put("template", "templates/list-stylists.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/listClients", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("clients", Client.all());
      model.put("template", "templates/list-clients.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/client/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      Client client = Client.find(Integer.parseInt(request.params(":id")));
      Stylist stylist = Stylist.find(client.getStylistId());

      model.put("client", client);
      model.put("stylist", stylist);
      model.put("template", "templates/client.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
