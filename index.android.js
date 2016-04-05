import React, {
  AppRegistry,
  Component,
  StyleSheet,
  processColor,
  Text,
  View,
  TouchableHighlight,
} from 'react-native';

import ToastAndroid from './ToastAndroid';
import NativeLinearGradient from './NativeLinearGradient';
import ColorSeekbarNative from './ColorSeekbarNative';
var incrementColor = require('./incrementColor');

class ReactNativeExample extends Component {
  constructor(props) {
    super(props);
    this.state= {
        count: 0,
        colorTop: '#000000',
        colorBottom: '#cccccc',
    };
  }
  
  componentDidMount() {
    setInterval(() => {
      this.setState({
        count: this.state.count + 1,
        colorTop: incrementColor(this.state.colorTop, 1),
        colorBottom: incrementColor(this.state.colorBottom, -1),
      });
    }, 20);
  }
  
  showToast() {
      ToastAndroid.show('Awesome', ToastAndroid.SHORT);
  }

  render() {
    return (
        <View style={styles.container}>
             <TouchableHighlight underlayColor={this.state.colorTop} style={{backgroundColor: this.state.colorBottom, padding: 10}}
                onPress={this.showToast.bind(this)}>
                <Text>Click Me</Text>
            </TouchableHighlight>
            
            <View>
            <NativeLinearGradient
                onClick={this.showToast.bind(this)}
                colors={[this.state.colorTop, this.state.colorBottom]}
                style={styles.gradient} />

                <Text style={{color: this.state.colorTop}}>{this.state.colorTop}</Text>
                <Text style={{color: this.state.colorBottom}}>{this.state.colorBottom}</Text>
            </View>
            <ColorSeekbarNative color={this.state.colorTop} style={styles.seekbar}/>
        </View>
    );
  }
}

var styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'space-around',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  gradient: {
    width: 200,
    height: 200,
  },
  seekbar: {
    alignItems: 'center',
    justifyContent: 'center',
    height: 120,
  },
});

AppRegistry.registerComponent('ReactNativeExample', () => ReactNativeExample);
