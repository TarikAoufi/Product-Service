package fr.tao.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "P1", types = Product.class)
public interface ProjectionProduct {
	public double getPrice();
	public String getDesignation();
}
