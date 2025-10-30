import React from "react";
import PropTypes from "prop-types";
import "./Button.css";

export default class Button extends React.Component {
    static propTypes = {
        name: PropTypes.string.isRequired,
        clickHandler: PropTypes.func.isRequired,
        orange: PropTypes.bool,
        wide: PropTypes.bool,
    };

    handleClick = () => {
        this.props.clickHandler(this.props.name)
    };

    render() {
        const {name, orange, wide } = this.props;

        const className = [
            "component-button",
            orange ? "orange" : "",
            wide ? "wide" : "",
        ].filter(Boolean).join(" ");

        return(
            <div className={className}>
                <button onClick={this.handleClick}>{name}</button>
            </div>
        );
    }
}
