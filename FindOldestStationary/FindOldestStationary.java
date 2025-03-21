package FindOldestStationary;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FindOldestStationary {

    class Client { 
        Integer     id; 
        String      name; 
        Integer     age; 
        List<Phone> phones; 

        public Client(Integer id, String name, Integer age, List<Phone> phones) {
            this.id     = id;
            this.name   = name;
            this.age    = age;
            this.phones = phones;
        }
    }

    enum PhoneType {
        STATIONARY,
        MOBIL
    }

    class Phone {
        Long      number;
        PhoneType type; 

        public Phone (Long number, PhoneType type) {
            this.number = number;
            this.type   = type;
        }
    }

    List<Client> clients = List.of(
        new Client(1, "Andrey", 20, List.of( 
            new Phone(1001L, PhoneType.MOBIL), 
            new Phone(1882L, PhoneType.MOBIL)
        )),
        new Client(3, "Alex", 54, List.of( 
            new Phone(3001L, PhoneType.MOBIL), 
            new Phone(3001L, PhoneType.STATIONARY)
        )),
        new Client(2, "Fedor", 25, List.of( 
            new Phone(2001L, PhoneType.STATIONARY), 
            new Phone(2882L, PhoneType.MOBIL)
        ))
    );

    // Найти самого старого со стационарником
    public static void main(String[] args) {
        FindOldestStationary findOldestStationary = new FindOldestStationary();

        Optional<Client> oldestClient = findOldestStationary.clients
            .stream()
            .filter(client -> client.phones.stream()
                                           .anyMatch(phone -> phone.type.equals(PhoneType.STATIONARY)))
            .max(Comparator.comparing(client -> client.age));    
            
        oldestClient.ifPresent(client -> System.out.println("Самый старый клиент: " + client.name + " " + client.age));
    }
}