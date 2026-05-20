package org.example.annotations.annotationparametertypes;

@AnnotationWithAllParam(
        version = 2,
        enabled = true,
        name = "test class",
        annotationClass = String.class,
        role = Role.ADMIN,
        info = @Info(description = "annotation with all param inside description class"),
        tags = {"name", "test"}
)
public class AnnotationWithAllParamClassExample {
    public static void main(String[] args) {
        AnnotationWithAllParam annotation =
                AnnotationWithAllParamClassExample.class.getAnnotation(AnnotationWithAllParam.class);
        int version = annotation.version();
        boolean enabled = annotation.enabled();
        String name = annotation.name();
        Role role = annotation.role();
        Info info = annotation.info();
        Class<?> stringClass = annotation.annotationClass();
        String[] tags = annotation.tags();
        System.out.println("version : "  + version + " || enabled : " + enabled + " || name : " + name
         + " || role : " + role.name() + " || info : " + info.description() + " || tags[0] " + tags[0] +
                " || tags[1] " + tags[1] + " || class type : " + stringClass);
    }
}
