package com.rentalcars;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class MainREST {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String root(){
        return ("---------- Welcome ---------- \n" +
                "The following URL will take you to the tasks: \n" +
                "Task 1 - localhost:9999/task1 \n" +
                "Task 2 - localhost:9999/task2 \n" +
                "Task 3 - localhost:9999/task3 \n" +
                "Task 4 - localhost:9999/task4");

    }

    @Path("/task1")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String task1() {
        return Tasks.listCarsAscending(ReadJSON.read());
    }

    @Path("/task2")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String task2() {
        return Tasks.listSpecification(ReadJSON.read());
    }

    @Path("/task3")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String task3() {
        return Tasks.bestSupplierPerTypeDescending(ReadJSON.read());
    }

    @Path("/task4")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String task4() {
        return Tasks.listScores(ReadJSON.read());
    }
}
