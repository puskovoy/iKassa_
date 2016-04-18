package com.iKassa.testing;

import com.iKassa.entity.*;
import com.iKassa.util.Crud;
import org.json.JSONObject;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

/**
 * Created by Shevtsov on 027 27.03.16.
 */
public class CarTest {
    Crud service = new Crud();
    /*CrudBag serviceBag = new CrudBag();
    CrudUser serviceUser = new CrudUser();
    CrudClient serviceClient = new CrudClient();
    CrudInkassator serviceInkassator = new CrudInkassator();*/

    @Test
    public void testSaveRecord() throws Exception {
        //Создаем автомобиль для записи в БД
        Car car1 = new Car();
        car1.setName("Mers");
        car1.setCost(50000);
        car1.setNumber("AX7777SS");
        car1.setReleaseDate(new Date());

        //Записали в БД
        Car car = (Car) service.add(car1);

        //Вывели записанную в БД запись
        System.out.println(car);
    }

    @Test
    public void testSaveRecordUser() throws Exception {
        //Создаем автомобиль для записи в БД
        User user = new User();
        User user1 = new User();
        user.setName("admin");
        user.setPassword("admin");

        //Записали в БД
        user1 = (User) service.add(user);

        //Вывели записанную в БД запись
        System.out.println(user1);
    }

    @Test
    public void testSaveRecordBag() throws Exception {

        Bag bag = new Bag();
        bag.setNumber(205);
        bag.setIsFull(1);
        bag.setRoute(2);
        //bag.setClients(new Client("Зоря","Adres",12,5,2,15));

        //Записали в БД
        Bag bag1 = (Bag) service.add(bag);

        //Вывели записанную в БД запись
        System.out.println(bag1);
    }

    @Test
    public void testSaveRecordCl() throws Exception {
        Client client = new Client();
        client.setName("Holodok");
        client.setAdres("адрес4");
        client.setTimeVisit(36);
        client.setKodNumber(57);

        Client client1 = (Client) service.add(client);

        Bag bag = new Bag();
        bag.setNumber(217);
        bag.setIsFull(0);
        bag.setRoute(2);
        bag.setClients(client1);

        Bag bag1 = new Bag();
        bag1.setNumber(218);
        bag1.setIsFull(0);
        bag1.setRoute(2);
        bag1.setClients(client1);

        Bag bag2 = new Bag();
        bag2.setNumber(219);
        bag2.setIsFull(0);
        bag2.setRoute(2);
        bag2.setClients(client1);

        Bag bag3 = new Bag();
        bag3.setNumber(220);
        bag3.setIsFull(0);
        bag3.setRoute(2);
        bag3.setClients(client1);

        //Записали в БД
        Bag bagDB = (Bag) service.add(bag);
        Bag bagDB1 = (Bag) service.add(bag1);
        Bag bagDB2 = (Bag) service.add(bag2);
        Bag bagDB3 = (Bag) service.add(bag3);

        //Вывели записанную в БД запись
        System.out.println(client1);
        System.out.println(bagDB);
        System.out.println(bagDB1);
        System.out.println(bagDB2);
        System.out.println(bagDB3);
    }

    @Test
    public void testSaveRecordInkassator() throws Exception {
        //Создаем автомобиль для записи в БД
        Inkassator inkassator1 = new Inkassator();
        inkassator1.setName("Sata");
        inkassator1.setAge("29");


        //Записали в БД
        Inkassator inkassator = (Inkassator) service.add(inkassator1);

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
        Car car = (Car) service.add(car1);

        //Удвлем его с БД
        service.delete(car, car.getId());
    }

    @Test
    public void testSelect() throws Exception {
        //Создаем автомобиль для записи в БД
        Car car1 = new Car();
        car1.setName("Citroen‎");
        car1.setCost(30000);
        car1.setReleaseDate(new Date());

        //Записываем в БД
        Car car = (Car) service.add(car1);

        //Получние с БД Citroen‎
        Car carFromDB = (Car) service.get(car, car.getId());
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
        car1 = (Car) service.add(car1);

        car1.setCost(0);

        //Обновляем
        service.update(car1);

        //Получаем обновленую запись
        Car car2 = (Car) service.get(car1, car1.getId());
        System.out.println(car2);
    }

    @Test
    public void testGetAllUser() {
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
        service.add(user1);
        service.add(user2);
        service.add(user3);
        //Получаем все авто с БД
       /* List<Object> users = service.getAll(User.class);

        //Выводим полученый список авто
        for (Object c : users) {
            System.out.println(c);
        }*/
    }

    @Test
    public void testGetAllSviaz() {
        EntityManager entityManager = Persistence.createEntityManagerFactory("iKassa").createEntityManager();

        /*TypedQuery<Inkassator> namedQuery = entityManager.createQuery("FROM Inkassator", Inkassator.class);
        List<Inkassator> inkassators = namedQuery.getResultList();
        for (Inkassator inkassator1 : inkassators) {
            System.out.println(inkassator1);
        }*/
        /*TypedQuery<Client> namedQuery = entityManager.createQuery("from Bag b inner join b.clients", Client.class);
        List<Client> clients = namedQuery.getResultList();
        for (Client client : clients) {
            System.out.println(client);
        }*/
       /* TypedQuery<Bag> namedQuery = entityManager.createQuery("from Bag b inner join b.clients", Bag.class);
        List<Bag> bags = namedQuery.getResultList();
        for (Bag bag : bags) {
            System.out.println(bag);
        }*/
        /*Query namedQuery = entityManager.createQuery("from Inkassator where name = :paramName");
        namedQuery.setParameter("paramName","yyy");
        List<Inkassator> obj = namedQuery.getResultList();
        for (Inkassator client : obj) {
            System.out.println(client);
        }*/
        TypedQuery<Client> namedQuery1 = entityManager.createNamedQuery("CLIENT.getAll", Client.class);
        List<Client> clients = namedQuery1.getResultList();
        for (Client client: clients) {
            System.out.println(client);
        }
//Взять одну запись можно так
        Query namedQuery = entityManager.createQuery("from Bag where number = :paramName");
        namedQuery.setParameter("paramName",209);
        List obj = namedQuery.getResultList();

            System.out.println(obj);
        /*TypedQuery<Bag> namedQuery = entityManager.createQuery("BA.getAll", Bag.class);
        List<Bag> inkassators = namedQuery.getResultList();
        for (Bag inkassator1 : inkassators) {
            System.out.println(inkassator1);
        }*/

        /*Bag bag = (Bag) service.get(Bag.class,2);
        System.out.println(bag);*/
    }
}
