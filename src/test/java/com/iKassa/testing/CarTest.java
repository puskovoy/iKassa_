package com.iKassa.testing;

import com.iKassa.entity.Car;
import com.iKassa.entity.User;
import com.iKassa.util.CrudCar;
import com.iKassa.util.CrudUser;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Created by Shevtsov on 027 27.03.16.
 */
public class CarTest {
    CrudCar service = new CrudCar();
    CrudUser service1 = new CrudUser();

    @Test
    public void testSaveRecord() throws Exception {
        //Создаем автомобиль для записи в БД
        Car car1 = new Car();
        car1.setName("Mersedes");
        car1.setCost(50000);
        car1.setReleaseDate(new Date());

        //Записали в БД
        Car car = service.add(car1);

        //Вывели записанную в БД запись
        System.out.println(car);
    }

    @Test
    public void testDeleteRecord() throws Exception {
        //Создаем автомобиль для записи в БД
        Car car1 = new Car();
        car1.setName("Ferrari");
        car1.setCost(100000);
        car1.setReleaseDate(new Date());

        //Записуем его в БД
        Car car = service.add(car1);

        //Удвлем его с БД
        service.delete(car.getId());
    }

    @Test
    public void testSelect() throws Exception {
        //Создаем автомобиль для записи в БД
        Car car1 = new Car();
        car1.setName("Citroen‎");
        car1.setCost(30000);
        car1.setReleaseDate(new Date());

        //Записываем в БД
        Car car = service.add(car1);

        //Получние с БД Citroen‎
        Car carFromDB = service.get(car.getId());
        System.out.println(carFromDB);

    }

    @Test
    public void testUpdate() throws Exception {
        //Создаем автомобиль для записи в БД
        Car car1 = new Car();
        car1.setName("Lambordshini");
        car1.setCost(5000000);
        car1.setReleaseDate(new Date());

        //Записываем в БД
        car1 = service.add(car1);

        car1.setCost(0);

        //Обновляем
        service.update(car1);

        //Получаем обновленую запись
        Car car2 = service.get(car1.getId());
        System.out.println(car2);
    }
    @Test
    public void testGetAll(){
        //Создаем автомобиль для записи в БД
        User car1 = new User();
        car1.setName("Lexus");
        car1.setPassword("admin");

        //Создаем автомобиль для записи в БД
        User car2 = new User();
        car2.setName("Fiat");
        car2.setPassword("taz");

        //Создаем автомобиль для записи в БД
        User car3 = new User();
        car3.setName("Porsche");
        car3.setPassword("tuz");

        //Сохраняем все авто
        service1.add(car1);
        service1.add(car2);
        service1.add(car3);
        //Получаем все авто с БД
        List<User> cars = service1.getAll();

        //Выводим полученый список авто
        for(User c : cars){
            System.out.println(c);
        }
    }
}
