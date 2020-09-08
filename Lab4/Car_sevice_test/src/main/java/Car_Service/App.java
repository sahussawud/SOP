package Car_Service;

import java.util.ArrayList;
/**
 * Hello world!
 *
 */
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class App {
    @RequestMapping(value = "/car/{carId}", method = RequestMethod.GET)
    public ResponseEntity<Car> get(@PathVariable("carId") int id) {
        if (Car.getCarsInstance().get(id - 1) == null) {
            return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
        }
        Car car = Car.getCarsInstance().get(id - 1);
        return new ResponseEntity<Car>(car, HttpStatus.OK);

    }

    @RequestMapping(value = "/car", method = RequestMethod.POST)
    public ResponseEntity<ArrayList<Car>> create(@RequestBody Car car) {
        Car.getCarsInstance().add(car);
        return new ResponseEntity<ArrayList<Car>>(Car.getCarsInstance(), HttpStatus.OK);
    }

    @RequestMapping(value = "/car/{carId}", method = RequestMethod.PATCH)
    public ResponseEntity<ArrayList<Car>> update(@RequestBody final Car car, @PathVariable("carId") int id) {
        Car.getCarsInstance().set(id - 1, car);
        return new ResponseEntity<ArrayList<Car>>(Car.getCarsInstance(), HttpStatus.OK);
    }

    @RequestMapping(value = "/car/{carId}", method = RequestMethod.DELETE)
    public ResponseEntity<ArrayList<Car>> delete(@PathVariable("carId") int id) {
        Car.getCarsInstance().remove(id - 1);
        return new ResponseEntity<ArrayList<Car>>(Car.getCarsInstance(), HttpStatus.OK);
    }

    public static void main(final String[] args) {
        SpringApplication.run(App.class, args);
    }

}
