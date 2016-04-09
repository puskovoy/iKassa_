package com.iKassa.testing;

import com.iKassa.entity.Car;
import com.iKassa.entity.Inkassator;
import com.iKassa.entity.User;
import com.iKassa.util.CrudCar;
import com.iKassa.util.CrudInkassator;
import com.iKassa.util.CrudUser;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Created by Shevtsov on 027 27.03.16.
 */
public class CarTest {
    CrudCar service = new CrudCar();
    CrudUser serviceUser = new CrudUser();
    CrudInkassator serviceInkassator = new CrudInkassator();

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
    public void testSaveRecordInkassator() throws Exception {
        //Создаем автомобиль для записи в БД
        Inkassator inkassator1 = new Inkassator();
        inkassator1.setName("Anton");
        inkassator1.setAge("25");
        inkassator1.setRoute(4);
        inkassator1.setCard(230);

        //Записали в БД
        Inkassator inkassator = serviceInkassator.add(inkassator1);

        //Вывели записанную в БД запись
        System.out.println(inkassator);
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
    public void testGetAllUser(){
        //Создаем автомобиль для записи в БД
        User user1 = new User();
        user1.setName("Tom");
        user1.setPassword("admin");

        //Создаем автомобиль для записи в БД
        User user2 = new User();
        user2.setName("Bob");
        user2.setPassword("taz");

        //Создаем автомобиль для записи в БД
        User user3 = new User();
        user3.setName("Gary");
        user3.setPassword("tuz");

        //Сохраняем все авто
        serviceUser.add(user1);
        serviceUser.add(user2);
        serviceUser.add(user3);
        //Получаем все авто с БД
        List<User> users = serviceUser.getAll();

        //Выводим полученый список авто
        for(User c : users){
            System.out.println(c);
        }
    }
}
