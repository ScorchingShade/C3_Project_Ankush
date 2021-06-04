import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {
    Restaurant restaurant;
    //REFACTOR ALL THE REPEATED LINES OF CODE
    private void mockData()
    {
        LocalTime openingTime = LocalTime.parse("10:30:00");
        LocalTime closingTime = LocalTime.parse("22:00:00");

        restaurant =new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        restaurant.addToMenu("Sweet corn soup",119,true);
        restaurant.addToMenu("Vegetable lasagne", 26,false);
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>OPEN/CLOSED<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    //-------FOR THE 2 TESTS BELOW, YOU MAY USE THE CONCEPT OF MOCKING, IF YOU RUN INTO ANY TROUBLE
    @Test
    public void is_restaurant_open_should_return_true_if_time_is_between_opening_and_closing_time(){
        mockData();

        LocalTime currentTime = LocalTime.parse("15:45:00");
        boolean restaurantStatus = restaurant.isRestaurantOpen(currentTime);
        assertTrue(restaurantStatus);
    }

    @Test
    public void is_restaurant_open_should_return_false_if_time_is_outside_opening_and_closing_time(){
        mockData();

        LocalTime currentTime = LocalTime.parse("22:45:00");
        boolean restaurantStatus = restaurant.isRestaurantOpen(currentTime);
        assertFalse(restaurantStatus);

    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<OPEN/CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    //>>>>>>>>>>>>>>>>>>>>>>>>>>>MENU<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void adding_item_to_menu_should_increase_menu_size_by_1(){
        mockData();

        int initialMenuSize = restaurant.getMenu().size();
        restaurant.addToMenu("Sizzling brownie",319,true);
        assertEquals(initialMenuSize+1,restaurant.getMenu().size());
    }
    @Test
    public void removing_item_from_menu_should_decrease_menu_size_by_1() throws itemNotFoundException {
        mockData();

        int initialMenuSize = restaurant.getMenu().size();
        restaurant.removeFromMenu("Vegetable lasagne");
        assertEquals(initialMenuSize-1,restaurant.getMenu().size());
    }
    @Test
    public void removing_item_that_does_not_exist_should_throw_exception() {
        mockData();

        assertThrows(itemNotFoundException.class,
                ()->restaurant.removeFromMenu("French fries"));
    }
}