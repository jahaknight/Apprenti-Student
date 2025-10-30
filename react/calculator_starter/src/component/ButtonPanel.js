import Button from "./Button";
import React from "react";
import PropTypes from "prop-types";

import "./ButtonPanel.css";

export default class ButtonPanel extends React.Component {
    static propTypes = {
        clickHandler: PropTypes.func.isRequired,
    };

    handleClick = (buttonName) => {
        this.props.clickHandler(buttonName);
    };

    renderRow(names, { orange = false, wideZero = false } = {}) {
        return names.map((n) => (
            <Button
        key={n}
        name={n}
        orange={orange && !["0", "."].includes(n)}
        wide={wideZero && n === "0"}
        clickHandler={this.handleClick}
      />
    ));
  }

  render() {
    return (
      <div className="component-button-panel">
        <div>{this.renderRow(["AC", "+/-", "%", "÷"], { orange: true })}</div>
        <div>{this.renderRow(["7", "8", "9", "x"], { orange: true })}</div>
        <div>{this.renderRow(["4", "5", "6", "-"], { orange: true })}</div>
        <div>{this.renderRow(["1", "2", "3", "+"], { orange: true })}</div>
        <div>{this.renderRow(["0", ".", "="], { orange: true, wideZero: true })}</div>
      </div>
    );
  }

}
