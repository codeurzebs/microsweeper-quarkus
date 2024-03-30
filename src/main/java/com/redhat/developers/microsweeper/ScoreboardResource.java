package com.redhat.developers.microsweeper;

import com.redhat.developers.microsweeper.model.Score;
import com.redhat.developers.microsweeper.service.ScoreboardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/scoreboard")
public class ScoreboardResource {

    @Inject
    ScoreboardService scoreboardService;

    final Logger logger = LoggerFactory.getLogger(getClass());

    @GET
    public List<Score> getScoreboard() {
        return scoreboardService.getScoreboard();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addScore(Score score) throws Exception {
        scoreboardService.addScore(score);
    }

    @DELETE
    public long clearAll() {
        return scoreboardService.clearScores();
    }

}
