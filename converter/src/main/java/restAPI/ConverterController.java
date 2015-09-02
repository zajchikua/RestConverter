package restAPI;

import com.sun.jersey.api.client.Client;
import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/converter")
/*
app is going to
est' papka Rest, package admin, package security i oni zamapleny
kuda zamaplen naw Rest API — controller mapping /convert
controller (v package controller) — mapping klassa,
kotoryy prinimaet zapros i otdayot ego na backend dlya obrabotki
dte — metod v klasse controllera
@Path(«dte»)
@Path(«dte/{e}») Pathparameter e

 */
public class ConverterController {
    EcxhangeServices services = new EcxhangeServices();
    @Path("/ETD/{euro}")
    @GET
    @Produces("application/json")
    public Response convertEuroToDollar (@PathParam("euro") Double euro){
        Double euroResUSD = services.euroToDol(euro);
        /*
        in order to send the response to the client (to the browser)
        create Json object, put there the result (dictionary)
         */
        JSONObject object = new JSONObject();
        object.put("USD", euroResUSD);
        return Response.status(200).entity(object.toString()).build();
    }
    @Path("/DTE/{dollar}")
    @GET
    @Produces("application/json")
    public Response convertDollarToEuro(@PathParam("dollar") Double dollar){
        Double dolResEUR = services.dolToEuro(dollar);
        JSONObject object = new JSONObject();
        object.put("EUR", dolResEUR);
        return Response.status(200).entity(object.toString()).build();
    }
}
