package fr.pizzeria.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ToString {
	boolean upperCase() default false;
	String	separateCode() default "";
	String	afterPrix() default "";
	String	beforePrix() default "";
	String	beforeCategorie() default "";
	String	afterCategorie() default "";
}
