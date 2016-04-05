import React, {
  Component,
  StyleSheet,
  processColor,
  requireNativeComponent,
  PropTypes,
  View,
  Event,
  Text,
} from 'react-native';

class ColorSeekbarNative extends Component {
    constructor(props) {
        super(props);
        this.state= {
            value: 0,
        };
    }
    
    
    _onChange(event) {
        this.state.value = event.nativeEvent.progress;
    }
    
    render() {
        var { style, color} = this.props;
            
        return (
            <View style={style}>
                <ColorSeekbarAndroid
                onChange={this._onChange.bind((this))}
                style={{flex: 1, alignSelf: 'stretch', width: 200}}
                color={[color].map(processColor)}
                />
                <Text style={{color: this.state.colorBottom, flex: 2}}>React: {this.state.value}</Text>
            </View>
        );
    }
}

var ColorSeekbarAndroid = requireNativeComponent('ColorSeekBar', null);
module.exports = ColorSeekbarNative;
  