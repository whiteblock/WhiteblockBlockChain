package com.neotys.ethereumJ.CustomActions;

import com.neotys.action.argument.ArgumentValidator;
import com.neotys.action.argument.Option;
import com.neotys.extensions.action.ActionParameter;

import static com.neotys.action.argument.DefaultArgumentValidator.INTEGER_VALIDATOR;
import static com.neotys.action.argument.DefaultArgumentValidator.NON_EMPTY;
import static com.neotys.action.argument.Option.AppearsByDefault.True;
import static com.neotys.action.argument.Option.OptionalRequired.Required;
import static com.neotys.extensions.action.ActionParameter.Type.TEXT;

enum SendTransactionOption implements Option {

    ipOfTheWhiteblockNode("ipOfTheWhiteblockNode", Required, True, TEXT,
                "Ip of one of the Whiteblock Node ",
                "Ip of one of the Whiteblock Node",
                NON_EMPTY),
    from("from", Required, True, TEXT,
            "Address of the account that will send the transaction",
                    "Address of the account that will send the transaction",
                        NON_EMPTY),
    to("to", Required, True, TEXT,
            "Address of the account that will receive the transaction",
            "Address of the account that will receive the transaction",
            NON_EMPTY),
    keystore("keystore", Required, True, TEXT,
            "Keystore of the from account ",
            "Keystore of the from account ",
            NON_EMPTY),
    amount("amount", Required, True, TEXT,
            "Amount to send",
            "Amount to send",
            NON_EMPTY);

    private final String name;
    private final Option.OptionalRequired optionalRequired;
    private final Option.AppearsByDefault appearsByDefault;
    private final ActionParameter.Type type;
    private final String defaultValue;
    private final String description;
    private final ArgumentValidator argumentValidator;

    SendTransactionOption(final String name, final Option.OptionalRequired optionalRequired,
                       final Option.AppearsByDefault appearsByDefault,
                       final ActionParameter.Type type, final String defaultValue, final String description,
                       final ArgumentValidator argumentValidator) {
        this.name = name;
        this.optionalRequired = optionalRequired;
        this.appearsByDefault = appearsByDefault;
        this.type = type;
        this.defaultValue = defaultValue;
        this.description = description;
        this.argumentValidator = argumentValidator;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public Option.OptionalRequired getOptionalRequired() {
        return optionalRequired;
    }

    @Override
    public Option.AppearsByDefault getAppearsByDefault() {
        return appearsByDefault;
    }

    @Override
    public ActionParameter.Type getType() {
        return type;
    }

    @Override
    public String getDefaultValue() {
        return defaultValue;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public ArgumentValidator getArgumentValidator() {
        return argumentValidator;
    }

}
