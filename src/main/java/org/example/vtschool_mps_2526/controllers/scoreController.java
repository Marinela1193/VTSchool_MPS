package org.example.vtschool_mps_2526.controllers;

import org.example.vtschool_mps_2526.models.dao.ScoreDAO;
import org.example.vtschool_mps_2526.models.dto.ScoreDTO;
import org.example.vtschool_mps_2526.models.entities.ScoreEntity;
import org.example.vtschool_mps_2526.service.serviceScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/scores")
class scoreController {
    @Autowired
    serviceScore serviceScore;

    @Autowired
    private ScoreDAO scoreDAO;

    @GetMapping("/scores")
    public ResponseEntity<?> getScores() {
        return ResponseEntity.ok(scoreDAO.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getScore(@Validated @PathVariable Integer id) {
        return ResponseEntity.ok(scoreDAO.findById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<?> addScore(@Validated @RequestBody ScoreDTO score) {

        Optional<ScoreEntity> optional = scoreDAO.findById(score.getId());
        if (optional.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        ScoreEntity score1 = serviceScore.saveScore(score);

        return ResponseEntity.ok().build();
    }
    @PutMapping("/actualizar")
    public ResponseEntity<?> updateScore(@Validated @RequestBody ScoreDTO score) {
        Optional<ScoreEntity> optional = scoreDAO.findById(score.getId());
        if (optional.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        ScoreEntity score1 = serviceScore.updateScore(score);
        return ResponseEntity.ok(score1);
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> deleteScore(@Validated @PathVariable Integer id) {
        if (!scoreDAO.existsById(id)) {
            return ResponseEntity.badRequest().build();
        }
        serviceScore.deleteScoreById(id);
        return ResponseEntity.ok("Score eliminado correctamente");
    }
}
