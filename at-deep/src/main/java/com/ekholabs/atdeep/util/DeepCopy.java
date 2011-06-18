package com.ekholabs.atdeep.util;

import java.lang.reflect.Field;

import com.ekholabs.atdeep.annotation.DeepProperty;
import com.ekholabs.atdeep.exception.DeepException;

/**
 * @author Wilder Rodrigues (wilder.rodrigues@myekho.com)
 * @version 1.0
 * @since 1.0
 */
public final class DeepCopy {

	private static DeepCopy instance;
	
	static {
		instance = new DeepCopy();
	}

	private DeepCopy() {
	}

	/**
	 * Singleton method.
	 * 
	 * @return the instance of <code>DeepCopy</code> utility.
	 */
	public synchronized static DeepCopy getInstance() {
		return instance;
	}

	/**
	 * @param from
	 *            - Type containing data to be copied from.
	 * @param to
	 *            - Type where the data has to be copied to.
	 * 
	 * @throws DeepException
	 *             - if any of the following exceptions happen:
	 *             IllegalArgumentException, IllegalAccessException,
	 *             SecurityException, NoSuchFieldException and
	 *             InstantiationException. The <code>DeepException</code> will
	 *             be thrown containing the root cause of the exception.
	 */
	public void copyProperties(Object from, Object to) throws DeepException {

		Class<?> fromClass = from.getClass();

		try {
			final Field[] fields = fromClass.getDeclaredFields();

			for (final Field f : fields) {
				f.setAccessible(true);
				final DeepProperty property = f
						.getAnnotation(DeepProperty.class);

				if (property != null) {

					if (property.isComplexType()) {
						Object fromCompType = f.get(from);
						
						if (fromCompType != null) {
							Object toCompType = property.reverseType()
									.newInstance();

							copyProperties(fromCompType, toCompType);

							Field reverseField = setFieldValue(property, f,
									from, to);

							reverseField.setAccessible(true);
							reverseField.set(to, toCompType);
						}
					} else {
						Field reverseField = setFieldValue(property, f, from,
								to);

						reverseField.setAccessible(true);
						reverseField.set(to, f.get(from));
					}
				}
			}
		} catch (IllegalArgumentException e) {
			throw new DeepException(e);
		} catch (IllegalAccessException e) {
			throw new DeepException(e);
		} catch (SecurityException e) {
			throw new DeepException(e);
		} catch (NoSuchFieldException e) {
			throw new DeepException(e);
		} catch (InstantiationException e) {
			throw new DeepException(e);
		}
	}

	/**
	 * @param property
	 *            - DeepProperty annotation reference.
	 * @param fromField
	 *            - the field of the class from which the value has to be copied
	 *            from.
	 * @param from
	 *            - origin class.
	 * @param to
	 *            - destination class.
	 * 
	 * @return Field - the field of the class to which the value has to be
	 *         copied to.
	 * 
	 * @throws SecurityException
	 *             - this exception will be caught by the calling method and
	 *             wrapped into a <code>DeepException</code>.
	 * @throws NoSuchFieldException
	 *             - this exception will be caught by the calling method and
	 *             wrapped into a <code>DeepException</code>.
	 * @throws IllegalArgumentException
	 *             - this exception will be caught by the calling method and
	 *             wrapped into a <code>DeepException</code>.
	 * @throws IllegalAccessException
	 *             - this exception will be caught by the calling method and
	 *             wrapped into a <code>DeepException</code>.
	 */
	private Field setFieldValue(DeepProperty property, Field fromField,
			Object from, Object to) throws SecurityException,
			NoSuchFieldException, IllegalArgumentException,
			IllegalAccessException {

		Class<?> toClass = to.getClass();

		Field reverseField = null;

		String propertyName = property.propertyName();
		if (propertyName != null && !propertyName.trim().equals("")) {
			reverseField = toClass.getDeclaredField(propertyName);
		} else {
			reverseField = toClass.getDeclaredField(fromField.getName());
		}
		return reverseField;
	}
}