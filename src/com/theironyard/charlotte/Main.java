package com.theironyard.charlotte;

import spark.ModelAndView;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    private static ArrayList<Restaurant> restaurants = new ArrayList<>();

    public static void main(String[] args) {
        restaurants.add(new Restaurant(1, "Papa Johns", "1 Papa John Avenue", "Pizza", "A billion", 5));
        restaurants.add(new Restaurant(2, "McDonalds", "12 Ronald Lane", "Bad", "Cheap", 1));
        restaurants.add(new Restaurant(3, "Mellow Mushroom", "420 Willie Nelson Dr.", "Weed", "more than I want always", 5));

        Spark.get("/restaurants", (req, res) -> {

            HashMap m = new HashMap();

            m.put("restaurants", restaurants);
            return new ModelAndView(m, "restaurants.html");
        }, new MustacheTemplateEngine());

        Spark.get("/restaurants/:id", (req, res) -> {
            int id = Integer.valueOf(req.params("id"));
            HashMap m = new HashMap();

            m.put("restaurant", getRestaurantById(id));

            return new ModelAndView(m, "restaurant.html");
        }, new MustacheTemplateEngine());


        Spark.post("/restaurants/:id", (req, res) -> {
            int id = Integer.valueOf(req.params("id"));

            Restaurant current = getRestaurantById(id);

            current.setAddress(req.queryParams("address"));
            current.setId(Integer.valueOf(req.queryParams("id")));
            current.setName(req.queryParams("name"));
            current.setPrice(req.queryParams("price"));
            current.setType(req.queryParams("type"));
            current.setRating(Integer.valueOf(req.queryParams("rating")));

            res.redirect("/");

            return "";
        });
    }

    private static Restaurant getRestaurantById(int id) {
        for (Restaurant r : restaurants) {
            if (r.getId() == id) {
                return r;
            }
        }

        return null;
    }
}

