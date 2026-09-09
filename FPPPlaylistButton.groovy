/*
 *  FPP Playlist Button
 *
 *  Child button driver used by FPP Playlist Player.
 *
 *  Author: Jon Wallace
 *  License: MIT
 */

metadata {
  definition(name: "FPP Playlist Button", namespace: "jonw", author: "Jon Wallace") {
    capability "Actuator"
    capability "Momentary"
    capability "Refresh"

    attribute "lastPushed", "string"
  }
}

def installed() {
  initialize()
}

def updated() {
  initialize()
}

def initialize() {
  // No-op
}

def push() {
  sendEvent(name: "lastPushed", value: new Date().format("yyyy-MM-dd HH:mm:ss", location.timeZone), isStateChange: true)

  if (parent) {
    parent.componentPush(device)
  }
}

def refresh() {
  if (parent) {
    parent.componentRefresh(device)
  }
}
