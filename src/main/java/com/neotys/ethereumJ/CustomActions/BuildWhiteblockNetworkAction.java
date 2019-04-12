package com.neotys.ethereumJ.CustomActions;

import com.google.common.base.Optional;
import com.neotys.action.argument.Arguments;
import com.neotys.action.argument.Option;
import com.neotys.ethereumJ.common.utils.Whiteblock.WhiteblockUtils;
import com.neotys.extensions.action.Action;
import com.neotys.extensions.action.ActionParameter;
import com.neotys.extensions.action.engine.ActionEngine;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class BuildWhiteblockNetworkAction implements Action {
    private static final String BUNDLE_NAME = "com.neotys.ethereumJ.BuildWhiteblockNetwork.bundle";
    private static final String DISPLAY_NAME = ResourceBundle.getBundle(BUNDLE_NAME, Locale.getDefault()).getString("displayName");
    private static final String DISPLAY_PATH = ResourceBundle.getBundle(BUNDLE_NAME, Locale.getDefault()).getString("displayPath");

    @Override
    public String getType() {
        return "BuildWhiteblockNetwork";
    }

    @Override
    public List<ActionParameter> getDefaultActionParameters() {
        final ArrayList<ActionParameter> parameters = new ArrayList<>();

        for (final BuildWhiteblockNetworkOption option : BuildWhiteblockNetworkOption.values()) {
            if (Option.AppearsByDefault.True.equals(option.getAppearsByDefault())) {
                parameters.add(new ActionParameter(option.getName(), option.getDefaultValue(),
                        option.getType()));
            }
        }

        return parameters;
    }

    @Override
    public Class<? extends ActionEngine> getEngineClass() {
        return BuildWhiteblockNetworkActionEngine.class;
    }

    @Override
    public boolean getDefaultIsHit() {
        return false;
    }

    @Override
    public Icon getIcon() {
        return WhiteblockUtils.getWhiteblockIcon();
    }

    @Override
    public String getDescription() {
        return "Build a BlockChain Network.\n\n" + Arguments.getArgumentDescriptions(BuildWhiteblockNetworkOption.values());

    }

    @Override
    public String getDisplayName() {
        return DISPLAY_NAME;
    }

    @Override
    public String getDisplayPath() {
        return DISPLAY_PATH;
    }

    @Override
    public Optional<String> getMinimumNeoLoadVersion() {
        return Optional.of("6.7");
    }

    @Override
    public Optional<String> getMaximumNeoLoadVersion() {
        return Optional.absent();
    }

}
