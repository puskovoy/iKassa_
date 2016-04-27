package com.iKassa.testing;

import com.iKassa.entity.*;
import com.iKassa.util.Crud;
import com.iKassa.util.Validation;
import org.json.JSONObject;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarTest {
    private Crud service = new Crud();
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
        user.setName("admin");
        user.setPassword("admin");

        //Записали в БД
        User user1 = (User) service.add(user);

        //Вывели записанную в БД запись
        System.out.println(user1);
    }

    @Test
    public void testSaveRecordBag() throws Exception {

        Bag bag = new Bag();
        bag.setNumber(205);
        bag.setIsFull(1);
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

        Client clientDB1 = (Client) service.add(client);

        Bag bag = new Bag();
        bag.setNumber(217);
        bag.setIsFull(0);
        bag.setClients(clientDB1);

        Bag bag1 = new Bag();
        bag1.setNumber(218);
        bag1.setIsFull(0);
        bag1.setClients(clientDB1);

        Bag bag2 = new Bag();
        bag2.setNumber(219);
        bag2.setIsFull(0);
        bag2.setClients(clientDB1);

        Bag bag3 = new Bag();
        bag3.setNumber(220);
        bag3.setIsFull(0);
        bag3.setClients(clientDB1);

        //Записали в БД
        Bag bagDB = (Bag) service.add(bag);
        Bag bagDB1 = (Bag) service.add(bag1);
        Bag bagDB2 = (Bag) service.add(bag2);
        Bag bagDB3 = (Bag) service.add(bag3);

        Client client0 = new Client();
        client.setName("Алвик");
        client.setAdres("вул.Польова,81");
        client.setTimeVisit(20);
        client.setKodNumber(296);

        Client clientDB2 = (Client) service.add(client0);

        Bag bag4 = new Bag();
        bag4.setNumber(929);
        bag4.setIsFull(0);
        /*bag4.setClients(clientDB2);*/

        Bag bag5 = new Bag();
        bag5.setNumber(930);
        bag5.setIsFull(0);
        /*bag5.setClients(clientDB2);*/

        Bag bag6 = new Bag();
        bag6.setNumber(931);
        bag6.setIsFull(0);
        /*bag6.setClients(clientDB2);*/

        Bag bag7 = new Bag();
        bag7.setNumber(932);
        bag7.setIsFull(0);
        /*bag7.setClients(clientDB2);*/

        //Записали в БД
        Bag bagDB5 = (Bag) service.add(bag4);
        Bag bagDB6 = (Bag) service.add(bag5);
        Bag bagDB7 = (Bag) service.add(bag6);
        Bag bagDB4 = (Bag) service.add(bag7);
        //Вывели записанную в БД запись
        System.out.println(clientDB1);
        System.out.println(clientDB2);
        System.out.println(bagDB);
        System.out.println(bagDB1);
        System.out.println(bagDB2);
        System.out.println(bagDB3);
        System.out.println(bagDB4);
        System.out.println(bagDB5);
        System.out.println(bagDB6);
        System.out.println(bagDB7);

        Set<Client> clientSet = new HashSet<Client>();
        clientSet.add(clientDB1);
        clientSet.add(clientDB2);

        Set<Bag> bagSet = new HashSet<Bag>();
        bagSet.add(bagDB);
        bagSet.add(bagDB1);
        bagSet.add(bagDB2);
        bagSet.add(bagDB3);
        bagSet.add(bagDB4);
        bagSet.add(bagDB5);
        bagSet.add(bagDB6);
        bagSet.add(bagDB7);

        Route route = new Route();
        route.setNumber(1);
        /*route.setClients(clientSet);*/

        Route route1 = (Route) service.add(route);

        System.out.println(route1);

        Inkassator inkassator = new Inkassator();
        inkassator.setName("Stas");
        inkassator.setAge("30");
/*        inkassator.setBagSet(bagSet);*/

        Inkassator inkassatorDB = (Inkassator) service.add(inkassator);
        System.out.println(inkassatorDB);

        Card card = new Card();
        card.setNumber("209");
        card.setClient(clientDB1);

        Card cardDB = (Card) service.add(card);
        System.out.println(cardDB);
    }

    @Test
    public void testSaveRecordCardClient() throws Exception {

        Card card = new Card();
        card.setNumber("189");

        Card cardDB = (Card) service.add(card);

        Client client = new Client();
        client.setName("ТОВ 'Промінь'");
        client.setAdres("вул.Гарібальді,5-а");
        client.setTimeVisit(1645);
        client.setKodNumber(146);
        client.setCard(cardDB);

        Client clientDB = (Client) service.add(client);
        Set<Client> clientSet = new HashSet<Client>();
        clientSet.add(clientDB);

        Route route = new Route();
        route.setNumber(2);
        route.setClients(clientSet);
        Route routeDB = (Route) service.add(route);

        Bag bag = new Bag();
        bag.setNumber(875);
        bag.setIsFull(0);
        bag.setClients(clientDB);

        Bag bag1 = new Bag();
        bag1.setNumber(876);
        bag1.setIsFull(0);
        bag1.setClients(clientDB);

        Bag bag2 = new Bag();
        bag2.setNumber(877);
        bag2.setIsFull(0);
        bag2.setClients(clientDB);

        Bag bag3 = new Bag();
        bag3.setNumber(878);
        bag3.setIsFull(0);
        bag3.setClients(clientDB);

        //Записали в БД
        Bag bagDB = (Bag) service.add(bag);
        Bag bagDB1 = (Bag) service.add(bag1);
        Bag bagDB2 = (Bag) service.add(bag2);
        Bag bagDB3 = (Bag) service.add(bag3);

        System.out.println(bagDB);
        System.out.println(bagDB1);
        System.out.println(bagDB2);
        System.out.println(bagDB3);
        System.out.println(cardDB);
        System.out.println(routeDB);
    }

    @Test
    public void testSaveRecordClientCard() throws Exception {
        Bag bag1 = new Bag();
        bag1.setNumber(318);
        bag1.setIsFull(0);

        Bag bag2 = new Bag();
        bag2.setNumber(319);
        bag2.setIsFull(0);

        Bag bag3 = new Bag();
        bag3.setNumber(320);
        bag3.setIsFull(0);

        Bag bagDB1 = (Bag) service.add(bag1);
        Bag bagDB2 = (Bag) service.add(bag2);
        Bag bagDB3 = (Bag) service.add(bag3);

        Card card = new Card();
        card.setNumber("325");

        Card cardDB = (Card) service.add(card);

        Set<Bag> bagSet = new HashSet<Bag>();
        bagSet.add(bagDB1);
        bagSet.add(bagDB2);
        bagSet.add(bagDB3);

        Client client = new Client();
        client.setName("Полевой");
        client.setAdres("вул.Польова,84");
        client.setTimeVisit(22);
        client.setKodNumber(297);
        client.setCard(cardDB);
        client.setBag(bagSet);

        Client clientDB1 = (Client) service.add(client);
        System.out.println(clientDB1);
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

    /*@Test
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
       *//* List<Object> users = service.getAll(User.class);

        //Выводим полученый список авто
        for (Object c : users) {
            System.out.println(c);
        }*//*
    }*/

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


        /*TypedQuery<Client> namedQuery1 = entityManager.createNamedQuery("CLIENT.getAll", Client.class);
        List<Client> clients = namedQuery1.getResultList();
        for (Client client : clients) {
            System.out.println(client);
        }
        TypedQuery<Card> namedQuery = entityManager.createNamedQuery("CARD.getAll", Card.class);
        List<Card> cards = namedQuery.getResultList();
        for (Card card : cards) {
            System.out.println(card);
        }*/
        /*TypedQuery<Route> namedQuery2 = entityManager.createNamedQuery("ROUTE.getAll", Route.class);
        List<Route> routes = namedQuery2.getResultList();
        for (Route route : routes) {
            System.out.println(route);
        }*/
//Взять одну запись можно так
        Query namedQuery2 = entityManager.createQuery("from Client where kodNumber = :paramName");
        namedQuery2.setParameter("paramName", 145);
        List obj = namedQuery2.getResultList();

        System.out.println(obj);
        /*TypedQuery<Bag> namedQuery = entityManager.createQuery("BA.getAll", Bag.class);
        List<Bag> inkassators = namedQuery.getResultList();
        for (Bag inkassator1 : inkassators) {
            System.out.println(inkassator1);
        }*/

        /*Bag bag = (Bag) service.get(Bag.class,2);
        System.out.println(bag);*/
    }

    @Test
    public void testCarInkassator() throws Exception {
        //Создаем автомобиль для записи в БД
        Car car1 = new Car();
        car1.setName("Citroen‎");
        car1.setCost(30000);
        car1.setReleaseDate(new Date());
        Inkassator inkassator1 = new Inkassator();
        inkassator1.setName("Sata");
        inkassator1.setAge("29");
        //Записали в БД
        Inkassator inkassator = (Inkassator) service.add(inkassator1);

        Set<Inkassator> inkassatorSet = new HashSet<Inkassator>();
        inkassatorSet.add(inkassator);
        car1.setInkassatorSet(inkassatorSet);
        //Записываем в БД
        Car car = (Car) service.add(car1);
        System.out.println(car);
        //Получние с БД Citroen‎
        Car carFromDB = (Car) service.get(car, car.getId());
        System.out.println(carFromDB);

    }
    @Test
    public void testLogin() throws Exception {
        Validation.checkUser("aaaaaa","aaaaaaa7");

    }
}
