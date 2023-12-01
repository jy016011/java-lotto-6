package lotto.controller;

import lotto.service.GameService;

public class LottoGame {
    private GameService gameService;

    public void init() {
        gameService = new GameService();
    }

    public void run() {

    }
}
