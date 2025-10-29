import React from "react";
import PropTypes from "prop-types";

import "./Display.css";

export default class Display extends React.Component {
    static propTypes = {
        value: PropTypes.string,
    };

    static defaultProps = {
        value: "0",
    };

    render() {
        const { value } = this.props;
        return (
          <div className="component-display">
            <div>{value}</div>
          </div>
        );
      }    
}
