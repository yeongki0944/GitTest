import React from 'react';
import './App.css';
import SockJsClient from "react-stomp";
import UsernameGenerator from "username-generator";
import Fetch from "json-fetch";
import { TalkBox } from "react-talk";
import randomstring from"randomstring";

class App extends React.Component {

  constructor(props) {
    super(props);
    // randomUserId is used to emulate a unique user id for this demo usage
    this.randomUserName = UsernameGenerator.generateUsername("-");
    this.randomUserId = randomstring.generate();
    this.sendURL = "/message/1";
    this.state = {
      clientConnected : false,
      messages : [],
      roomId : 1
    };

  }

  //수신 시 동작
  onMessageReceive = (msg, topic) => {
    //alert(JSON.stringify(msg) + " @ " +  JSON.stringify(this.state.messages)+" @ " + JSON.stringify(topic));
    this.setState(prevState => ({
      messages: [...prevState.messages, msg]
    }));
  }

  sendMessage = (msg, selfMsg) => {
    try {
      var send_message = {
        "roomId": this.state.roomId,
        "user" : selfMsg.author,
        "message" : selfMsg.message
      }
      this.clientRef.sendMessage("/app/message", JSON.stringify(send_message));
      return true;
    } catch(e) {
      return false;
    }
  }

  fetchurl;
  componentWillMount() {
    console.log("call history");
    this.fetchurl = "http://localhost:8080/history/"+this.state.roomId;;
    Fetch(this.fetchurl, {
      method: "GET"
    }).then((response) => {
      this.setState({ messages: response.body });
      this.setState({ roomId: this.state.roomId});
      console.log(response.body);
    });
  }

  render() {
    const wsSourceUrl = "http://localhost:8080/chatting";
    return (
        <div>
          <TalkBox topic="/topic/public/1" currentUserId={ this.randomUserId }
                   currentUser={ this.randomUserName } messages={ this.state.messages }
                   onSendMessage={ this.sendMessage } connected={ this.state.clientConnected }/>

          <SockJsClient url={ wsSourceUrl } topics={["/topic/public/1"]}
                        onMessage={ this.onMessageReceive } ref={ (client) => { this.clientRef = client }}
                        onConnect={ () => {this.setState({ clientConnected: true }) } }
                        onDisconnect={ () => { this.setState({ clientConnected: false }) } }
                        debug={ false } style={[{width:'100%', height:'100%'}]}/>
        </div>
    );
  }
}

export default App;
