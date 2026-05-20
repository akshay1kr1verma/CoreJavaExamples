package org.example.annotations.repeatable;

@Role(value = "Eagle Admin")
@Role(value = "Eagle User")
public class EagleRepeatableAnnotationExample {

    public void fly()
    {
        System.out.println("Eagle is flying");
    }

    public static void main(String[] args) {
        Role [] rolesArray = EagleRepeatableAnnotationExample.class.getAnnotationsByType(Role.class);
        for(Role r : rolesArray){
            System.out.println(r.value());
        }

    }
}
