import React, {
  Component,
  StyleSheet,
  processColor,
  requireNativeComponent,
  PropTypes,
  View,
} from 'react-native';

class LinearGradient extends Component {
    constructor(props) {
        super(props);
        this.state= {
            count: 0,
            colorTop: '#000000',
            colorBottom: '#cccccc',
        };
    }
    render() {
        var { style, children, colors, locations, start, end } = this.props;
        // Children is an array of components
        return (
            <View style={style}>
                <NativeLinearGradient
                style={{position: 'absolute', top: 0, left: 0, bottom: 0, right: 0}}
                colors={colors.map(processColor)}
                start={start}
                end={end}
                locations={locations}
                />
                { children }
            </View>
        );
    }
}

var NativeLinearGradient = requireNativeComponent('BVLinearGradient', null);
module.exports = LinearGradient;
  