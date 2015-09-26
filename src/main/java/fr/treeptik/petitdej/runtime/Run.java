package fr.treeptik.petitdej.runtime;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Run {

	public static void main(String[] args) {
		System.out.println("jpa-exemple2 begin");
		EntityManager entityManager = Persistence.createEntityManagerFactory(
				"PETITDEJ").createEntityManager();
		entityManager.close();
		System.out.println("PETITDEJ");
	}
}
