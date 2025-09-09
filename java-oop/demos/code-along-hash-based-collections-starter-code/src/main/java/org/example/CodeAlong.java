package org.example;

public class CodeAlong {
    public static void main(String[] args) {
        BirthdayManager jahasBirthday = new BirthdayManager();

        System.out.println("Adding new Friend Ralph");
        Friend ralph = new Friend("Ralph", "09/02/1974");
        jahasBirthday.addFriend(ralph);


        System.out.println("Adding new Friend Mike");
        Friend mike = new Friend("Mike", "01/17/1977");
        jahasBirthday.addFriend(mike);

       for (Friend friend : jahasBirthday.getFriends()){
            System.out.println(friend);
        }

        System.out.println("Ralph is giving gifts");
       jahasBirthday.addGift(ralph, new Gift("Marlboros", "Carton"));
       jahasBirthday.addGift(ralph, new Gift("Whiskey", "Gallon"));

        System.out.println("Mike is giving gifts");
        jahasBirthday.addGift(mike, new Gift("Tattoo", "Large"));

        System.out.println("Time to open your gifts");
        for (Friend friend : jahasBirthday.getMap().keySet()){
            System.out.println(friend.getName());
            System.out.println("Gave the following:");
            for (Gift gift : jahasBirthday.getMap().get(friend)){
                System.out.println(gift.description + " " + gift.size);
            }
        }

        Friend seamus = new Friend("Seamus", "09/07/1974");
        System.out.println(jahasBirthday.getMap().get(seamus));

        
    }

}
