package com.stdmar.fcleanarchprj.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.stdmar.fcleanarchprj.Const;
import com.stdmar.fcleanarchprj.MyApplication;
import com.stdmar.fcleanarchprj.ui.MainActivity;

import javax.inject.Inject;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.commands.Back;
import ru.terrakok.cicerone.commands.Command;
import ru.terrakok.cicerone.commands.Forward;
import ru.terrakok.cicerone.commands.Replace;
import ru.terrakok.cicerone.commands.SystemMessage;

/**
 * Created by sma on 06.09.17.
 */

public class BaseActivity extends MvpAppCompatActivity {

    protected MyApplication myApplication;

    @Inject
    public Router router;
    @Inject
    public NavigatorHolder navigatorHolder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        inject();
    }

    @Override
    protected void onResume() {
        super.onResume();
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        navigatorHolder.removeNavigator();
        super.onPause();
    }

    protected void inject() {

    }

    protected Navigator navigator = new Navigator() {
        @Override
        public void applyCommand(Command command) {
            if (command instanceof Forward) {
                forward((Forward) command);
            } else if (command instanceof Replace) {
                replace((Replace) command);
            } else if (command instanceof Back) {
                back();

            } else if (command instanceof SystemMessage) {
                Toast.makeText(BaseActivity.this, ((SystemMessage) command).getMessage(),
                        Toast.LENGTH_SHORT).show();
            } else {
                Log.e("Cicerone", "Illegal command for this screen: " + command.getClass().getSimpleName());
            }
        }
    };

    protected void forward(Forward command) {
        switch (command.getScreenKey()) {
            case Const.ScreenKey.MAIN_ACTIVITY_SCREEN:
                startActivity(new Intent(this, MainActivity.class));
                break;
            default:
                Log.e("Cicerone", "Unknown screen: " + command.getScreenKey());
                break;
        }
    }

    protected void replace(Replace command) {
        switch (command.getScreenKey()) {
            case Const.ScreenKey.START_ACTIVITY_SCREEN:
                forward(new Forward(command.getScreenKey(), command.getTransitionData()));
                finish();
                break;
            default:
                Log.e("Cicerone", "Unknown screen: " + command.getScreenKey());
                break;
        }
    }

    protected void back() {
        //
        finish();
    }
}
