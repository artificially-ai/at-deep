package com.ekholabs.atdeep.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * DeepProperty Annotation is part of the @Deep Framework and can be used to copy properties
 * from one object to another; chiefly from a Java Bean (i.e. Transfer Object, Value Object)
 * to a JPA Entity.
 * 
 * In its first version, @Deep can be used to copy the following properties:
 * 
 *  1. primitive types
 *  2. Wrapper Classes
 *  3. Complex Types (developer specific classes)
 *  
 * Copying Lists and Arrays will be offered in the future.
 * 
 * @author Wilder Rodrigues (wilder.rodrigues@myekho.com)
 * @version 1.0
 * @since 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
public @interface DeepProperty {
	
	/**
	 * This attribute is used to inform the reverse type used for copying properties.
	 * For example, to copy from a Java Bean to a JPA Entity, the developer would have
	 * to use '@Deep' following the snippet bellow:
	 * 
	 * <code>
	 * 		//Java Bean code
	 * 		@DeepProperty
	 * 		private String code;
	 * 
	 *  	@DeepProperty(reverseType = MyEntity.class, isComplexType = true)
	 *  	private MyBean bean;
	 *  	...
	 * </code>
	 * 
	 * With the code above, the developer says that the attributes within the bean MyBean
	 * have to be copied into the attributes into the entity MyEntity. If there are any
	 * other complex attributes into MyBean, they have to be annotated following the same
	 * principle.
	 */
	Class<?> reverseType() default Class.class;
	
	/**
	 * This attribute is used to inform the property name on the reverse type. If not used,
	 * the reverse type has to have it properties with the same names as the origin bean.
	 * See two examples bellow:
	 * 
	 * <code>
	 * 		//<b>NOT</b> informing propertyName attribute
	 * 		//Java Bean code
	 * 		@DeepProperty
	 * 		private String code;
	 * 
	 * 		//JPA Entity code
	 * 		@Column(name = "CODE")
	 * 		private String code;
	 * 
	 * 		//<b>Informing</b> propertyName attribute
	 * 			//Java Bean code
	 * 		@DeepProperty(propertyName = "id")
	 * 		private String code;
	 * 
	 * 		//JPA Entity code
	 * 		@Column(name = "CODE")
	 * 		private String id;
	 * </code>
	 */
	String propertyName() default "";
	
	/**
	 * This attribute is used to mark a property as a complex type (e.g. any class that is
	 * not a Wrapper Class nor a primitive value). Its use is quite straight forward.
	 * 
	 * <code>
	 * 		//Java Bean code
	 * 		@DeepProperty
	 * 		private String code;
	 * 
	 *  	@DeepProperty(reverseType = MyEntity.class, isComplexType = true)
	 *  	private MyBean bean;
	 *  	...
	 * </code>
	 */
	boolean isComplexType() default false;
}