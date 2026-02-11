package org.example.annotations;

@Role(value = "Eagle Admin")
@Role(value = "Eagle User")
public class EagleRepeatableAnnotationExample {

    public void fly()
    {
        System.out.println("Eagle is flying");
    }

    public static void main(String[] args) {
        Role [] rolesArray = new EagleRepeatableAnnotationExample().getClass().getAnnotationsByType(Role.class);
        for(Role r : rolesArray){
            System.out.println(r.value());
        }

    }
}
