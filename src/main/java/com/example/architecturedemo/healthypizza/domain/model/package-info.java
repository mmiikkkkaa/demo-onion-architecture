/**
 * <p>The domain model package should contain all domain model classes. Those classes should make sure,
 * that they contain valid values all the time. It should not be possible to create objects with invalid data,
 * neither from infrastructure (e.g. by incomplete rest request or manipulated database contents)
 * nor from automated software tests (invalid test data).</p>
 *
 * <p>Also complex domain model classes should not use java data types like String, Integer, BigDecimal etc.
 * instead, for EVERY specific value a wrapper object should be created, that a) describe the content of a variable
 * (e.g. "Map<ProductCategory,Priority>" describes way better what the map contains then "Map<String,Int>")</p>
 *
 * <p>Domain model objects should always be immutable, so no unexpected side effects can occur. If a domain model
 * object should have a different value, a copy with the new desired value should be created.</p>
 */
package com.example.architecturedemo.healthypizza.domain.model;