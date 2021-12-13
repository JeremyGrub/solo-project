package com.jeremy.askwinston.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jeremy.askwinston.models.Dinner;
import com.jeremy.askwinston.models.User;
import com.jeremy.askwinston.repositories.DinnerRepository;

@Service
public class DinnerService {
	
	private final DinnerRepository dinnerRepository;
	
	public DinnerService(DinnerRepository dinnerRepository) {
		this.dinnerRepository = dinnerRepository;
	}
	
	public List<Dinner> allDinner() {
		return dinnerRepository.findAll();
	}
	
	public Dinner createDinner(Dinner dinner) {
		System.out.println("Creating a Dinner option");
		return dinnerRepository.save(dinner);
	}
	
	public void deleteDinner(Long id) {
		dinnerRepository.deleteById(id);
	}
	
	public Dinner getOneDinner(Long id) {
		return dinnerRepository.findById(id).orElse(null);
	}
	
	public Dinner getRandomDinner() {
		 List<Dinner> list = dinnerRepository.findRandomDinner();
		 return list.get(0);
	}
	
	public Dinner updateDinner(Long id, String showDinner, String dinnerHours, String dinnerLink) {
		Dinner dinner = getOneDinner(id);
		dinner.setDinnerName(showDinner);
		dinner.setDinnerHours(dinnerHours);
		dinner.setDinnerLink(dinnerLink);
		return dinnerRepository.save(dinner);
	}
	
	public void chooseDinner(Dinner dinner, User user) {
		List<User> allWhoChose = dinner.getWhoChose();
		allWhoChose.add(user);
		dinnerRepository.save(dinner);
	}
	
	public void unChooseDinner(Dinner dinner, User user) {
		List<User> whoChose = dinner.getWhoChose();
		whoChose.remove(user);
		dinnerRepository.save(dinner);
	}
}
