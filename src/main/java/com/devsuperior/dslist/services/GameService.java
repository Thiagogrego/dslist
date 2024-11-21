package com.devsuperior.dslist.services;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;
@Service
public class GameService {
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll() {
		List<Game> games = gameRepository.findAll();
		List<GameMinDTO> dto = games.stream().map(x -> new GameMinDTO(x)).collect(Collectors.toList());
		return dto;
	}
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game game = gameRepository.findById(id).get();
		GameDTO dto = new GameDTO(game);
		return dto;
	}
}