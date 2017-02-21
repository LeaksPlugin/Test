package com.andrei1058.skygiants.listeners;

import com.andrei1058.skygiants.game.*;

class PlayerQuitListener$2 implements Runnable {
    @Override
    public void run() {
        Winner.getWinner();
    }
}